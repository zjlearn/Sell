<#include 'head.ftl'/>

<div class="container">

    <!--列出所有以购买的物品的table-->
    <table class="table table-hover">
        <caption>已购买的内容</caption>
        <thead>
        <tr>
            <th>内容图片</th>
            <th>内容名称</th>
            <th>购买时间</th>
            <th>购买数量</th>
            <th>购买价格</th>
        </tr>
        </thead>
        <tbody>
            <#assign  sum=0>
            <#list orders as order>
            <tr class="row">
                <!--真实的来源-->
                <td>
                    <a href=/show?id=${order.productId}>
                        <img
                         src=${order.photoAddress}  alt="图片不存在" style="
    width: 106px;
    height: 60px;
" >
                    </a>
                </td>
                <td><h4><a href=/show?id=${order.productId}>${order.productName}</a></h4></td>
                <td><span >${order.orderTime}</span></td>
                <td><span>${order.num}</span></td>
                <td><span>¥</span><span >${order.price}</span></td>
                <#assign  sum = sum+ order.num *order.price>
            </tr>
            </#list >
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">
                <div class="total">总计：</div>
            </td>
            <td><span >¥</span><span>${sum}</span></td>
        </tr>
        </tfoot>

    </table>
</div>

</body>
</html>