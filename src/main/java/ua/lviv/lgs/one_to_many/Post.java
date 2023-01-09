package ua.lviv.lgs.one_to_many;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column(name = "tytle")
private String tytle;

@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "post")
@Column(nullable = false)
private Set<Comment> comments;





public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTytle() {
	return tytle;
}

public void setTytle(String tytle) {
	this.tytle = tytle;
}

public Set<Comment> getComments() {
	return comments;
}

public void setComments(Set<Comment> comments) {
	this.comments = comments;
}

@Override
public int hashCode() {
	return Objects.hash(id, tytle);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if ((obj == null) || (getClass() != obj.getClass()))
		return false;
	Post other = (Post) obj;
	return Objects.equals(id, other.id) && Objects.equals(tytle, other.tytle);
}

@Override
public String toString() {
	return "Post [id=" + id + ", tytle=" + tytle + "]";
}

public Post() {
	super();
}


}
