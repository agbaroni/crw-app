package io.github.agbaroni.crw.app;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@NamedQueries({ @NamedQuery(name = Account.SELECT_ALL, query = "SELECT account FROM Account account") })
@Table(name = "ACCOUNTS")
@ToString
public class Account implements Serializable {

    private static final long serialVersionUID = 13921698814124L;

    public static final String SELECT_ALL = "Account.selectAll";

    @Column(name = "USERNAME")
    @Getter
    @Id
    @Setter
    private String username;

    @Column(name = "PASSWORD")
    @Getter
    @Setter
    private String password;

    @Getter
    @JoinColumn(name = "USER_")
    @ManyToOne
    @Setter
    private User user;

    @Column(name = "VERSION")
    @Getter
    @JsonbTransient
    @Setter
    @Version
    private int version;

    public Account() {
    }

    public Account(String username) {
	this.username = username;
    }
}
