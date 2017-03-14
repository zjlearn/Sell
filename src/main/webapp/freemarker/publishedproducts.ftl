<!--打印出所有的product, 打印的规则是按照-->
<div class="container">
    <ul >
        <#if products ??>
            <#list products as product>
                <#if product_index%4==0>
                <div class="row">
                </#if>
                <li class="col-md-3">
                    <a href=/Sell/show?id=${product.id}>
                        <div>
                            <img class="img-responsive" src=${product.photoAddress} alt=${product.productName}>
                            <h3>${product.productName}</h3>
                            <div>
                                <span>￥</span>
                                <span>${product.price}</span>
                                <!--判断如果相应的num 为0 输出已售完-->
                                <#if product.stock==0>
                                    <span>已售完！！</span>
                                <#else>
                                    <span>库存：${product.stock}</span>
                                </#if>
                            </div>
                        </div>
                    </a>
                </li>
                <#if product_index%4==3 || !product_has_next>
                </div>
                </#if>
            </#list>
        <#else>
            <p>没有发布任何商品</p>
        </#if>
    </ul>
</div>