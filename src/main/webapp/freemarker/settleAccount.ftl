<#include 'head.ftl'>

<script type="text/javascript" src="<@spring.url'/Scripts/sell.js'/>"></script>

<div class="container" id="settleAccount">
    <div class="row">
        <h2>已添加到购物车的内容</h2>
    </div>
    <table id="newTable" class="table table-hover">
        <thead>
        <tr>
            <th>商品名称</th>
            <th>数量</th>
            <th>价格(元)</th>
        </tr>
        </thead>
        <tbody>
        <#if cart ? exists>
            <#assign  productMap =cart.products>
            <#list productMap ?keys as id>
                <#assign  productInfo = productMap[id]>
            <tr>
                <td>${productInfo.name}</td>
                <td>
                 <span id="plusNum" onclick="reduceproduct()">
                     <a>-</a>
                 </span>
                    <span id="allNum">${productInfo.num}</span>
                    <span id="addNum" onclick="addproduct()">
                        <a>+</a>
                    </span>
                </td>
                <td>${productInfo.price}</td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <div class="container">
        <div class="row">
            <div class="center-pill">
                <a class="btn btn-danger " href="/Sell">退出</a>
                <a class="btn btn-success" href="/Sell/createorder">购买</a>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>