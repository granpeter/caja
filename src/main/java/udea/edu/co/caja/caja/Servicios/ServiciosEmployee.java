package udea.edu.co.caja.caja.Servicios;

import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Entidades.Profile;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiciosEmployee {
    private ArrayList listaEmpleados = this.listEmployee();
    public ArrayList <Employee > listEmployee (){

     Profile  perfil=new Profile("2", "Administrador","312443443", LocalDate.of(2022,06,07), LocalDate.of(2022,06,07));

       setListaEmpleados(new ArrayList<Employee>());
        Employee empleado1 = new Employee(1,"empleado1@gmail.com",LocalDate.of(2022,07,01),LocalDate.of(2022,07,6));
        Employee empleado2 = new Employee(2,"empleado2@gmail.com",LocalDate.of(2021,12,03),LocalDate.of(2022,07,6));
        Employee empleado3 = new Employee(65200,"empleado456789@gmail.com",LocalDate.of(2021,12,03),LocalDate.of(2022,07,6));
         empleado1.setProfile(perfil);
        empleado2.setProfile(perfil);
        empleado3.setProfile(perfil);
        getListaEmpleados().add(empleado1);
        getListaEmpleados().add(empleado2);
        getListaEmpleados().add(empleado3);
        return getListaEmpleados();
    }


    public Employee buscarEmployee (int id) {


        Employee empleado=null;
         for (int i = 0; i < getListaEmpleados().size(); i++) {
            empleado = (Employee) getListaEmpleados().get(i);
            if (empleado.getId() == id) {
                break;
            }else{
                empleado=null;//fin del if
            }
        }// fin del for
        return empleado;
    }


    public boolean  saveEmployee(Employee empleado){
        this.getListaEmpleados().add(empleado);
        return true;
    }


    public ArrayList getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
}
