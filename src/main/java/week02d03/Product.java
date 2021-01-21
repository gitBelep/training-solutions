package week02d03;
class Product {
    private String name;
    private String code;

    public Product(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public boolean areTheyEqual(Product p){
        boolean first = name.equals(p.name);
        boolean second = code.length() - p.code.length()<2 && code.length() - p.code.length() >-2;
        return first && second;
    }

    public static void main(String[] args) {
        Product p1 = new Product("vaj", "2222");
        Product p2 = new Product("vaj","333322");
        Product p3 = new Product("gél","2244");
        Product p4 = new Product("gél","gél*");

        System.out.println(p1.areTheyEqual(p2));
        System.out.println(p1.areTheyEqual(p3));
        System.out.println(p2.areTheyEqual(p3));
        System.out.println(p3.areTheyEqual(p4));
    }
}
