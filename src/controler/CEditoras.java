/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author jairb
 */
public class CEditoras {

    ArrayList<Editora> editora = new ArrayList<>();
    int idEdt = 1;

    public void mokEditoras() {
        Editora edt = new Editora();
        edt.setIdEditora(this.addIdEdt());
        edt.setNmEditora("Senac");
        edt.setEndereco("Venancio Aires");
        edt.setTelefone("51 44223322");
        edt.setGerente("Visotto");
        this.addEditora(edt);
        Editora edt2 = new Editora();
        edt2.setIdEditora(this.addIdEdt());
        edt2.setNmEditora("Abril");
        edt2.setEndereco("São Paulo");
        edt2.setTelefone("11 33443344");
        edt2.setGerente("Abreu");
        this.addEditora(edt2);
    }

    public int addIdEdt() {
        return this.idEdt++;
    }

    public void addEditora(Editora e) {
        this.editora.add(e);
    }

    public ArrayList<Editora> getEditora() {
        return editora;
    }

    public Boolean verficaEditora(int idEditora) {
        Boolean verEditora = false;
        for (Editora edt : editora) {
            if (edt.getIdEditora() == idEditora) {
                verEditora = true;
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return verEditora;
    }
    
    public String getNomeEdt(int idEditora) {
        String nome = "";
        for (Editora edt : editora) {
            if (edt.getIdEditora() == idEditora) {
                nome = edt.getNmEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return nome;
    }

    public int getIdEditora(String nome) {
        int idEditora = 0;
        for (Editora edt : editora) {
            if (edt.getNmEditora().equals(nome)) {
                idEditora = edt.getIdEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return idEditora;
    }
}
