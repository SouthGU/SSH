package Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.Impl.RegisterDaoImpl;
import dao.RegisterDao;
import domain.Register;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/18:48
 * @Description:
 */
public class RegisterAction extends ActionSupport implements ModelDriven {

    private String password2;
    private Register register;
    private List<Register> users;
    private RegisterDao registerDao;

    public RegisterAction(){
        register = new Register();
        registerDao = new RegisterDaoImpl();
    }


    public String addRegister(){
        registerDao.addRegister(register);
        return SUCCESS;
    }
    public String getAllRegister(){
        users = registerDao.getAllRegister();
        return "show";
    }

    public Object getModel() {
        return register;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public List<Register> getUsers() {
        return users;
    }

    public void setUsers(List<Register> users) {
        this.users = users;
    }

    public RegisterDao getRegisterDao() {
        return registerDao;
    }

    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }
}
