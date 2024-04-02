package util;

public class Server {
   public static String localhost = "http://192.168.56.1";
    public static String connectdb = localhost+ "/API/connectdb.php";

    public static String registeruser = localhost+"/API/registeruser.php";
    public static String login = localhost+"/API/login.php";
    public static String addproduct = localhost+"/API/addproduct.php";
    public static String addloaisp = localhost+"/API/addloaisp.php";
    public static String addHD = localhost+"/API/addhoadon.php";
    public static String getAllProduct = localhost+"/API/getspall.php";
    public static String getproductbyid = localhost+"/API/getproductbyid.php";
    public static String searchproductbyname = localhost+"/API/searchsp.php";
    public static String getuserbyemail = localhost+"/API/getuserbyemail.php";
    public static String getalluser = localhost+"/API/getuserall.php";
    public static String getallloai = localhost+"/API/getloaiall.php";
    public static String updateItemInCart = localhost+"/API/updateItemInCart.php";
    public static String getproductcart = localhost+"/API/getcart.php";
    public static String getUserByEmail = localhost+"/API/getuserbyemail.php";
    public static String getidorder = localhost+"/API/getIdOrder.php";
    public static String insertItemToCart = localhost+"/API/insertItemToCart.php";
    public static String deletedItemInCart = localhost+"/API/deletedItemInCart.php";
    public static String updateinfo = localhost+"/API/updateinfo.php";
    public static String insertdathang = localhost+"/API/insertdathang.php";
    public static String updateorder = localhost+"/API/updateorder.php";
    public static String insert = localhost+"/API/insert.php";
}
