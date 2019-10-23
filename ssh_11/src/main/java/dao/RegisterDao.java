package dao;

import domain.Register;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/23/18:39
 * @Description:
 */
public interface RegisterDao {

    public void addRegister(Register register);

    public List<Register> getAllRegister();
}