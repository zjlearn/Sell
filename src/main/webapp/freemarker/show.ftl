<#include 'head.ftl'>

<!--引入相关的-->
<script type="text/javascript" src="<@spring.url'/Scripts/layer/layer.js'/>"></script>
<script type="text/javascript" src="<@spring.url'/Scripts/sell.js'/>"></script>

<div class="container">
<#if product ??>
    <div class="row" id="showContent">
        <div class="col-md-4">
            <img class="img-responsive" src=${product.photoAddress} alt="商品实物图">
        </div>
        <div class="col-md-8 col-md-offset-4">
            <h2>${product.productName}</h2>
            <p>${product.summary}!</p>
            <div class="price">
                <span class="v-unit">￥</span>
                <span class="v-value">${product.price}</span>
            </div>

            <#if user ? exists>
                <!--编辑-->
                <#if product.ownerId==user.id>
                    <a class="btn btn-success" href=/Sell/product/edit/?productId=${product.id} role="button">编辑</a>
                <#else > <!--判断是否购买-->
                    <#if purchased==true>
                        <a class="btn btn-success" role="button">已购买</a>
                    <#else>
                        <div class="container">
                            购买数量：
                            <span id="plusNum">
                                <a>-</a>
                            </span>
                            <span id="allNum">1</span>
                            <span id="addNum">
                                <a>+</a>
                            </span>
                            <div class="row">
                                <a class="btn btn-success" id="add" data-id= ${product.id}
                                        data-title=${product.productName} data-price=${product.price}
                                        role="button"
                                   onclick="add2cart()"
                                >
                                    加入购物车
                                </a>
                            </div>
                        </div>
                    </#if>
                </#if>
            <#else >  <!--未登录的游客-->
                <div class="container">
                    购买数量：
                            <span id="plusNum" onclick="reduceproduct()">
                                <a>-</a>
                            </span>
                    <span id="allNum">1</span>
                            <span id="addNum" onclick="addproduct()">
                                <a>+</a>
                            </span>
                    <div class="row">
                        <a class="btn btn-success" id="add" onclick="add2cart()" data-id= ${product.id}
                                data-title=${product.productName} data-price=${product.price} role="button">
                            加入购物车
                        </a>
                    </div>
                </div>
            </#if>
        </div>
    </div>

    <div class="row">
        <h2>详细信息</h2>
    </div>
    <div class="row">
        <p>${product.detail}</p>
    </div>

</#if>

</div>

</body>
</html>