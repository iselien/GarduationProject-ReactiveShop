package com.yovelas.mapper;

import com.yovelas.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture\n" +
            "\t, g.goods_describe, g.goods_type_id\n" +
            "\t, (\n" +
            "\t\tSELECT Concat(MIN(goods_price), '-', MAX(goods_price))\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_price\n" +
            "\t, (\n" +
            "\t\tSELECT SUM(goods_inventory)\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id}\n" +
            "\t) AS goods_inventory\n" +
            "FROM goods g\n" +
            "ORDER BY g.goods_id;")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory"),
            @Result(property = "goodsSource",column = "goods_source"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")})
    List<Goods> selectAllGoods();

    @Select("SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture\n" +
            "\t, g.goods_describe, g.goods_type_id\n" +
            "\t, (\n" +
            "\t\tSELECT Concat(MIN(goods_price), '-', MAX(goods_price))\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_price\n" +
            "\t, (\n" +
            "\t\tSELECT SUM(goods_inventory)\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_inventory\n" +
            "FROM goods g\n" +
            "ORDER BY rand()\n" +
            "LIMIT 12")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory"),
            @Result(property = "goodsSource",column = "goods_source"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")})
    List<Goods> randSelectAllGoods();

    @Select("SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture\n" +
            "\t, g.goods_describe, g.goods_type_id\n" +
            "\t, (\n" +
            "\t\tSELECT Concat(MIN(goods_price), '-', MAX(goods_price))\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_price\n" +
            "\t, (\n" +
            "\t\tSELECT SUM(goods_inventory)\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_inventory\n" +
            "FROM goods g\n" +
            "\tJOIN goods_sub_type s ON g.goods_type_id = goods_sub_type_id\n" +
            "\tJOIN goods_type_main_with_sub_relationship r ON r.goods_type_main_with_sub_relationship_id = s.goods_sub_type_id\n" +
            "\tJOIN goods_main_type m ON r.goods_type_main_with_sub_relationship_main_id = m.goods_main_type_id\n" +
            "WHERE (g.goods_name LIKE #{keyWord}\n" +
            "\tOR g.goods_sub_name LIKE #{keyWord}\n" +
            "\tOR g.goods_describe LIKE #{keyWord}\n" +
            "\tOR s.goods_sub_type_name LIKE #{keyWord}\n" +
            "\tOR m.goods_main_type_name LIKE #{keyWord});")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory"),
            @Result(property = "goodsSource",column = "goods_source"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")})
    List<Goods> selectGoodsListByKeyWord(@Param("keyWord") String keyWord);

    @Select("SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture\n" +
            "\t, g.goods_describe, g.goods_type_id\n" +
            "\t, (\n" +
            "\t\tSELECT Concat(MIN(goods_price), '-', MAX(goods_price))\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_price\n" +
            "\t, (\n" +
            "\t\tSELECT SUM(goods_inventory)\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_inventory\n" +
            "FROM goods g\n" +
            "WHERE g.goods_id = #{goodsId};")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory"),
            @Result(property = "goodsSource",column = "goods_source"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")})
    Goods selectOneGoods(@Param("goodsId") int goodsId);

    @Select("SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture\n" +
            "\t, g.goods_describe, g.goods_type_id\n" +
            "\t, (\n" +
            "\t\tSELECT Concat(MIN(goods_price), '-', MAX(goods_price))\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_price\n" +
            "\t, (\n" +
            "\t\tSELECT SUM(goods_inventory)\n" +
            "\t\tFROM goods_data\n" +
            "\t\tWHERE goods_id = g.goods_id\n" +
            "\t) AS goods_inventory\n" +
            "FROM goods g\n" +
            "WHERE g.goods_type_id = #{goodsSubTypeId};")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory"),
            @Result(property = "goodsSource",column = "goods_source"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")})
    List<Goods> selectGoodsByGoodsSubType(@Param("goodsSubTypeId") int goodsSubTypeId);

    @Select("SELECT *\n" +
            "FROM goods_main_type")
    @Results({
            @Result(property = "goodsMainTypeId",column = "goods_main_type_id"),
            @Result(property = "goodsMainTypeName",column = "goods_main_type_name"),
            @Result(property = "goodsMainTypePicture",column = "goods_main_type_picture")})
    List<GoodsMainType> selectAllGoodsMainType();

    @Select("SELECT *\n" +
            "FROM goods_sub_type")
    @Results({
            @Result(property = "goodsSubTypeId",column = "goods_sub_type_id"),
            @Result(property = "goodsSubTypeName",column = "goods_sub_type_name"),
            @Result(property = "goodsSubTypePicture",column = "goods_sub_type_picture")})
    List<GoodsSubType> selectAllGoodsSubType();

    @Select("SELECT *\n" +
            "FROM goods_sub_type\n" +
            "WHERE goods_sub_type_id IN (\n" +
            "\tSELECT goods_type_main_with_sub_relationship_sub_id\n" +
            "\tFROM goods_type_main_with_sub_relationship r\n" +
            "\tWHERE r.goods_type_main_with_sub_relationship_main_id = #{goodsMainTypeId}\n" +
            ")")
    @Results({
            @Result(property = "goodsSubTypeId",column = "goods_sub_type_id"),
            @Result(property = "goodsSubTypeName",column = "goods_sub_type_name"),
            @Result(property = "goodsSubTypePicture",column = "goods_sub_type_picture")})
    List<GoodsSubType> selectGoodsSubTypeByGoodsMainTypeId(@Param("goodsMainTypeId") int goodsMainTypeId);

    @Select("SELECT *\n" +
            "FROM goods_parameter\n" +
            "WHERE id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsParameter",column = "goods_parameter"),
            @Result(property = "goodsOptional",column = "goods_optional")})
    List<GoodsParameter> selectAllGoodsParameterById(@Param("id") int id);

    @Select("SELECT *\n" +
            "FROM goods_parameter\n" +
            "WHERE goods_id = #{goodsId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsParameter",column = "goods_parameter"),
            @Result(property = "goodsOptional",column = "goods_optional")})
    List<GoodsParameter> selectAllGoodsParameterByGoodsId(@Param("goodsId") int goodsId);

    @Select("SELECT *\n" +
            "FROM goods_parameter_option\n" +
            "WHERE id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsParameterId",column = "goods_parameter_id"),
            @Result(property = "goodsOption",column = "goods_option"),
            @Result(property = "goodsPicture",column = "goods_picture")})
    List<GoodsParameterOption> selectAllGoodsParameterOptionById(@Param("id") int id);

    @Select("SELECT *\n" +
            "FROM goods_parameter_option\n" +
            "WHERE goods_parameter_id = #{goodsParameterId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsParameterId",column = "goods_parameter_id"),
            @Result(property = "goodsOption",column = "goods_option"),
            @Result(property = "goodsPicture",column = "goods_picture")})
    List<GoodsParameterOption> selectAllGoodsParameterOptionByParameterId(@Param("goodsParameterId") int goodsParameterId);

    @Select("SELECT *\n" +
            "FROM goods_data\n" +
            "WHERE id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsConfiguration",column = "goods_configuration"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory")})
    GoodsData selectGoodsDataById(@Param("id") int id);

    @Select("SELECT *\n" +
            "FROM goods_data\n" +
            "WHERE goods_id = #{goodsId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsConfiguration",column = "goods_configuration"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsInventory",column = "goods_inventory")})
    List<GoodsData> selectGoodsDataByGoodsId(@Param("goodsId") int goodsId);
}
