package com.example.utitl.utls;

public class Points
{
    //高德坐标转百度（传入经度）
    public static  String bd_encrypt(Double gg_lng, Double gg_lat) {
        Double X_PI = Math.PI * 3000.0 / 180.0;
        Double x = gg_lng, y = gg_lat;
        Double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        Double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        Double bd_lng = z * Math.cos(theta) + 0.0065;
        Double bd_lat = z * Math.sin(theta) + 0.006;
        return bd_lat + "";
    }

    //高德坐标转百度（传入纬度）
    public static  String bd_encrypts(Double gg_lng, Double gg_lat) {
        Double X_PI = Math.PI * 3000.0 / 180.0;
        Double x = gg_lng, y = gg_lat;
        Double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        Double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        Double bd_lng = z * Math.cos(theta) + 0.0065;
        Double bd_lat = z * Math.sin(theta) + 0.006;
        return "" + bd_lng;
    }

    //高德坐标转百度（传入纬度）
    public static  String bd_encryptss(Double gg_lng, Double gg_lat) {
        Double X_PI = Math.PI * 3000.0 / 180.0;
        Double x = gg_lng, y = gg_lat;
        Double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        Double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        Double bd_lng = z * Math.cos(theta) + 0.0065;
        Double bd_lat = z * Math.sin(theta) + 0.006;
        return bd_lat + " "+bd_lng;
    }

    //输入GCJ经纬度 转WGS纬度
    public static double WGSLat (double lat,double lon) {
        double PI = 3.14159265358979324;//圆周率
        double a = 6378245.0;//克拉索夫斯基椭球参数长半轴a
        double ee = 0.00669342162296594323;//克拉索夫斯基椭球参数第一偏心率平方
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * PI);
        return (lat - dLat);
    }

    //输入GCJ经纬度 转WGS经度
    public static double WGSLon (double lat,double lon) {
        double PI = 3.14159265358979324;//圆周率
        double a = 6378245.0;//克拉索夫斯基椭球参数长半轴a
        double ee = 0.00669342162296594323;//克拉索夫斯基椭球参数第一偏心率平方
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * PI);
        return (lon - dLon);
    }

    //转换经度所需
    public static double transformLon(double x, double y) {
        double PI = 3.14159265358979324;//圆周率
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }
    //转换纬度所需
    public static double transformLat(double x, double y) {
        double PI = 3.14159265358979324;//圆周率
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }
}
