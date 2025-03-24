package main.menuFeatures;

public interface IBasicOperations {
    void add(String subMenu);
    
    void list(String subMenu);
    
    void modify(String subMenu);
    
    void delete(String subMenu);

    boolean fileExists(String subMenu);
}
