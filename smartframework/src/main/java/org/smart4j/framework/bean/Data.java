package org.smart4j.framework.bean;

/**
 * Data类型的数据封装了一个Object类型的模型数据，框架会将该对象写入HttpServletResponse对象中，从而直接输出至浏览器。
 */
public class Data {

    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
