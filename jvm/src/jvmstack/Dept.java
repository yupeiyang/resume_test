package jvmstack;

import java.util.List;

class Dept{
    private String name;
    private List<Emp> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }
}
