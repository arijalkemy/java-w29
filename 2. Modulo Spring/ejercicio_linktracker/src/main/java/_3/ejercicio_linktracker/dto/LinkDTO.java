package _3.ejercicio_linktracker.dto;

public class LinkDTO {
    private Long id;
    private String link;
    private String password;
    private Integer count;

    //constructores

    public LinkDTO() {
    }

    public LinkDTO(Long id, String link, String password, Integer count) {
        this.id = id;
        this.link = link;
        this.password = password;
        this.count = 0;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    //to string


    @Override
    public String toString() {
        return "LinkDTO{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", password='" + password + '\'' +
                ", count=" + count +
                '}';
    }
}
