package __tests01.pojo.gorest;

public class User {
    int code;
    Object meta;
    UserData data;

    public User(){}

    public User(int code, Object meta, UserData userData) {
        this.code = code;
        this.meta = meta;
        this.data = userData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "code = " + code +
                "\nmeta = " + meta +
                "\nuserData:" + data;
    }
}
