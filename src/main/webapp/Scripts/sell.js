/**
 * Created by zjlearn on 2017/3/1.
 */

//对登录的密码进行加密
function encry(){
    var pass= $('#password').val();
    var encrypass= $.md5(pass)
    document.getElementById("password").value=encrypass;
}

//增加添加到购物车的商品的数量
function addproduct(){
    numtobuy=document.getElementById('allNum');
    var num = numtobuy.textContent;
    num ++;
    numtobuy.innerHTML = num;
}
//减少添加到购物车的数量
function reduceproduct(){
    numtobuy=document.getElementById('allNum');
    var num = numtobuy.textContent;
    num --;
    if(num ==0 )
        alert("商品数量已经为0，不能添加！")
    num=0;
    numtobuy.innerHTML = num;
}
//添加到购物车
function add2cart() {
    var info=document.getElementById('add')
    var num = document.getElementById('allNum').innerHTML;
    var price= info.dataset.price;
    var title=info.dataset.title;
    var id=info.dataset.id;
    layer.confirm('确定加入购物车吗？', {
        btn: ['确定', '取消']
    }, function () {  //确定加入购物车
        $.ajax({
            url: "addproduct",
            async: false,
            data: {"id": id, "title": title, "num": num, "price": price}
        })
        layer.closeAll('dialog');
    }, function () {  //不加入购物车, do nothing
        return;
    });
}

//控制radio的切换
function radioshow() {
    var myradio = document.getElementsByName("pic");
    var urldiv = document.getElementById("urlUpload");
    var filediv = document.getElementById("fileUpload");
    if (myradio[0].checked) {
        urldiv.style.display = "block";
        filediv.style.display = "none";
    } else {
        urldiv.style.display = "none";
        filediv.style.display = "block";
    }
}

//