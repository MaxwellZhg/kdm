package com.funtsui.dell.kotlindarggermvvm.bean;

/**
 * Created by zhg on 2019/3/20.
 */
public class ShelvesInfoBean {

    /**
     * data : {"channel_id":"market","name":"test","status":0,"sign":"8P7yhlqnYC5kynZsFqU5eA==","random":"ca15c01861eba35e"}
     * attributes : null
     * state : 0
     * message : ok
     */

    private DataBean data;
    private Object attributes;
    private int state;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * channel_id : market
         * name : test
         * status : 0
         * sign : 8P7yhlqnYC5kynZsFqU5eA==
         * random : ca15c01861eba35e
         */

        private String channel_id;
        private String name;
        private int status;
        private String sign;
        private String random;

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getRandom() {
            return random;
        }

        public void setRandom(String random) {
            this.random = random;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "channel_id='" + channel_id + '\'' +
                    ", name='" + name + '\'' +
                    ", status=" + status +
                    ", sign='" + sign + '\'' +
                    ", random='" + random + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShelvesInfoBean{" +
                "data=" + data +
                ", attributes=" + attributes +
                ", state=" + state +
                ", message='" + message + '\'' +
                '}';
    }
}
