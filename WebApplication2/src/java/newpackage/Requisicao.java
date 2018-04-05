/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import java.util.UUID;


/**
 *
 * @author 5967082
 */
public class Requisicao {
    
    //informações para por na sessao
    private boolean fezRequisicao;
    private String id;
    
    //tem que voltar para o usuario
    private List<String> openPorts;
    
    //veio do usuario
    private String ip;
    private int inicioPorta;
    private int finalPorta;
    
    public boolean getFezRequisicao() {
        return fezRequisicao;
    }

    public void setFezRequisicao(boolean fezRequisicao) {
        this.fezRequisicao = fezRequisicao;
    }

    public String getUId() {
        return id;
    }
    
    public void setUId(){
        id = UUID.randomUUID().toString();
    }

    public List<String> getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(List<String> openPorts) {
        this.openPorts = openPorts;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getInicioPorta() {
        return inicioPorta;
    }

    public void setInicioPorta(int inicioPorta) {
        this.inicioPorta = inicioPorta;
    }

    public int getFinalPorta() {
        return finalPorta;
    }

    public void setFinalPorta(int finalPorta) {
        this.finalPorta = finalPorta;
    }

    
    
    
}
