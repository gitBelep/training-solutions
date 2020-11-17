package stringconcat;

public class Name {
    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public Name(String familyName, String middleName, String givenName, Title title){
 //dupla konstruktor. De mi ez itt a következő sorban?
        this(familyName, middleName, givenName);
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName){
        if (familyName ==null || "".equals(familyName.trim())){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if (givenName ==null || "".equals(givenName.trim())){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle(){
        String wName = title.getName() +" "+ givenName +" "+ middleName +" "+ familyName;
        return wName;
    }
    public String concatNameHungarianStyle(){
        String hName;
        if (middleName.isEmpty()){
            if (title == null){
                hName = familyName.concat(" ").concat(givenName);
            }else{
                hName = title.getName().concat(" ").concat(familyName.concat(" ").concat(givenName));
            }
        } else {
            if (title == null){
                hName = familyName.concat(" ").concat(middleName).concat(" ").concat(givenName);
            }else {
                hName = title.getName().concat(" ").concat(familyName).concat(" ").concat(middleName).concat(" ").concat(givenName);
            }
        }
        return hName;
    }

    public boolean isEmpty(String asked){
        return asked ==null || "".equals(asked.trim());
    }
}
