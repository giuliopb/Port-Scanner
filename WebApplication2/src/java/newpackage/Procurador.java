/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 5967082
 */
public class Procurador {
    
  public List<String> procura(String ip, int inicioPorta, int finalPorta ) throws InterruptedException, ExecutionException {
    final ExecutorService es = Executors.newFixedThreadPool(20);
    
    final int timeout = 200;
    final List<Future<ScanResult>> futures = new ArrayList<>();
 
    for (int port = inicioPorta; port <= finalPorta; port++) { //loop´entre a porta minima e a maxima
     
        futures.add(portIsOpen(es, ip, port, timeout)); //add na lista de futures q é uma lista de scan result
    }
    es.awaitTermination(200L, TimeUnit.MILLISECONDS);
    List<String> openPorts = new ArrayList<>();  // essa variavel armazena as portas abertas encontradas na faixa
    
    for (final Future<ScanResult> f : futures) {//pega a lista de tutures e checa se ta aberta
        if (f.get().isOpen()) {
            openPorts.add(Integer.toString(f.get().getPort())); //  as portas abertas add na lista acima
            System.out.println(f.get().getPort());
        }
    }
    
    return openPorts;
    }

    public static Future<ScanResult> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
        return es.submit(new Callable<ScanResult>() {
            @Override
            public ScanResult call() {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, port), timeout);
                    socket.close();
                    return new ScanResult(port, true);
                } catch (Exception ex) {
                    return new ScanResult(port, false);
                }
            }
        });
    }
}