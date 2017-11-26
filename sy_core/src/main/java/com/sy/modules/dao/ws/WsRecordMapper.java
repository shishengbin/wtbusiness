package com.sy.modules.dao.ws;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.entity.ws.WsRecord;
import com.sy.modules.entity.ws.WsRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@MyBatisRepository
public interface WsRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int countByExample(WsRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int deleteByExample(WsRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long rId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int insert(WsRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int insertSelective(WsRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    List<WsRecord> selectByExampleWithRowbounds(WsRecordExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    List<WsRecord> selectByExample(WsRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    WsRecord selectByPrimaryKey(Long rId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WsRecord record, @Param("example") WsRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WsRecord record, @Param("example") WsRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WsRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ws_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WsRecord record);
}