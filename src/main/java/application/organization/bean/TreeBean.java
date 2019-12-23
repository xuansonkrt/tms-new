package application.organization.bean;


public class TreeBean {
    private Long id;
    private String text;
    private boolean children;
    private Long parent;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public boolean isChildren() {
        return children;
    }
    
    public void setChildren(boolean children) {
        this.children = children;
    }
    
    public Long getParent() {
        return parent;
    }
    
    public void setParent(Long parent) {
        this.parent = parent;
    }
    
    
}
