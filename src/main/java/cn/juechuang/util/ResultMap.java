package cn.juechuang.util;

/**
 * 返回数据的封装类
 */
public class ResultMap {
    //返回信息
    private String msg;
    //返回状态
    private Integer code;
    //返回的数据
    private Object data;

    public ResultMap() {
    }

    //三个参数的构造
    public ResultMap(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    //返回成功的数据
    public static ResultMap okData(Object data){
        return new ResultMap("成功", 200, data);
    }

    //返回成功状态
    public  static  ResultMap ok(){
        return new ResultMap("成功！", 200,null );
    }

    //返回失败状态
    public static ResultMap fail(){
        return new ResultMap("失败了滚蛋！", 500, null);
    }

    //返回异常的json
    public static ResultMap exce(String e){
        return new ResultMap(e, 500, null);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
