/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeBrasilPrev.repositorio.entidade;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.xml.bind.annotation.XmlRootElement;
import local.testeBrasilPrev.repositorio.entidade.base.Cliente__Base;

/**
 *
 * @author Vitor
 */
@Entity
@Table(name = "tbl_usuario")
@XmlRootElement
@Transactional(TxType.REQUIRES_NEW)
public class Cliente extends Cliente__Base {
    
}
