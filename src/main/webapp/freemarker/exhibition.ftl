<#include  'head.ftl'>

<!--展示取出的图片-->
<div class="container">
    <ul id="productshowTab" class="nav nav-tabs">
        <li class="active">
            <a href="#allproduct" data-toggle="tab" onclick="getAllProduct()">
                全部商品
            </a>
        </li>
        <li>
            <a href="#notpurchased" data-toggle="tab" onclick="getnotPurchasedProduct()">
                未购买的商品
            </a>
        </li>
        <li>
            <a href="#published" data-toggle="tab" onclick="getpublishedProduct()">
                发布的商品
            </a>
        </li>
    </ul>
</div>


<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="allproduct">
        <#include  'Allproducts.ftl'>
    </div>
    <div class="tab-pane fade" id="notpurchased">
        <p>未购买的内容</p>
    </div>
    <div class="tab-pane fade" id="published">
        <p>全部以发布的内容</p>
    </div>
</div>


<script>
    function getAllProduct() {
        result = $.ajax({url: "/Sell/product/?type=0", async: false})
        $('#allproduct').html(result.responseText)
    }
    function getnotPurchasedProduct() {
        result = $.ajax({url: "/Sell/product/?type=1", async: false})
        $('#notpurchased').html(result.responseText)
    }
    function getpublishedProduct() {
        result = $.ajax({url: "/Sell/product/?type=2", async: false})
        $('#published').html(result.responseText)
    }
</script>
</body>
</html>