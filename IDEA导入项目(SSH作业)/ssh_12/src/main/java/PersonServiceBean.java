/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/20:46
 * @Description:
 */
public class PersonServiceBean {
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }
    public void sayhello(String name){
        System.out.println(person.hello(name));
    }
}
