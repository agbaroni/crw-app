package io.github.agbaroni.crw.app;

import java.io.Serializable;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@NamedQueries({ @NamedQuery(name = User.SELECT_ALL, query = "SELECT user FROM User user") })
@Table(name = "USERS")
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 2273680631399L;

    public static final String SELECT_ALL = "User.selectAll";

    @Column(name = "ID")
    @Id
    @JsonbTransient
    private int id;

    @Column(name = "FIRST_NAME")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "LAST_NAME")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "VERSION")
    @Getter
    @JsonbTransient
    @Setter
    @Version
    private int version;

    @Getter
    @JsonbTransient
    @OneToMany(mappedBy = "user")
    @Setter
    private Set<Account> accounts;

    public User() {
    }

    public User(int id) {
	this.id = id;
    }
}
