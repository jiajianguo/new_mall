package com.xdj.www.core.constant;



import java.io.Serializable;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;



/**
 *
 *
 */
public class ResponseModel<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8017442806785923686L;

	private String code;  //返回状态码

    private String msg;   //返回信息说明

    private T data;       //返回对象信息

    private Long totalCount = 0L; //需要分页时返回的总条数

    public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public static ResponseModel<?> getInstance() {
		return new ResponseModel<Object>();
	}

	/**
     * 成功返回
     * @return
     */
    public static ResponseModel<?> getSuccessResponseModel() {
        return ResponseModel.getInstance().setCode(ResponseContants.RESPONSE_SUCCESS_CODE).setMsg(ResponseContants.RESPONSE_SUCCESS_MSG);
    }

    /**
     * 服务器错误
     * @return
     */
    public static ResponseModel<?> getFailedResponseModel() {
        return ResponseModel.getInstance().setCode(ResponseContants.RESPONSE_FAILED_CODE).setMsg(ResponseContants.RESPONSE_FAILED_MSG);
    }

    /**
     * 用户名密码校验错误
     * @return
     */
    public static ResponseModel<?> getLoginErrorResponseModel(){
        return ResponseModel.getInstance().setCode(ResponseContants.RESPONSE_LOGIN_ERROR_CODE).setMsg(ResponseContants.RESPONSE_LOGIN_ERROR_MSG);
    }

    /**
     * 失败返回
     * @param resultEnum
     * @return
     */
    public static ResponseModel<?> getFailedResponseModel(ErrorCode resultEnum) {
    	return ResponseModel.getFailedResponseModel(resultEnum, null);
    }

    /**
     * 失败返回
     * @param resultEnum
     * @param additionalMsg
     * @return
     */
    public static ResponseModel<?> getFailedResponseModel(ErrorCode resultEnum, String additionalMsg) {
    	ResponseModel<?> res = ResponseModel.getInstance().setCode(resultEnum.getValue()).setMsg(resultEnum.getMessage());
    	if(additionalMsg != null){
    		res.setMsg(res.getMsg()+additionalMsg);
    	}
    	return res;
    }


    public ResponseModel() {
    	this.setCode(ResponseContants.RESPONSE_SUCCESS_CODE);
    	this.setMsg(ResponseContants.RESPONSE_SUCCESS_MSG);
    }

    public ResponseModel(ErrorCode errorCode) {
        this.code = errorCode.getValue();
        this.msg = errorCode.getMessage();;
    }

    public ResponseModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseModel(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
        return code;
    }

    public ResponseModel<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseModel<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseModel<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        try {
            String str =
                    "ResponseModel{"
                            + "status='"
                            + code
                            + '\''
                            + ", msg='"
                            + msg
                            + '\''
                            +", totalCount='"
                            +totalCount
                            +'\''
                            + ", data="
                            + new ObjectMapper().writeValueAsString(data)
                            + '}';
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	@SuppressWarnings("rawtypes")
		BlockingDeque linkedBlockingDeque=new LinkedBlockingDeque();
    	@SuppressWarnings("unchecked")
		ThreadPoolExecutor threadPool=new ThreadPoolExecutor(4, 12, 4*60,TimeUnit.SECONDS,linkedBlockingDeque);
    	//threadPool.
	}
}
