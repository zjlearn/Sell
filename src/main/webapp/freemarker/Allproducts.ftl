<!--打印出所有的product, 打印的规则是按照-->
<div class="container">
    <ul id="plist">
    <#list products as product>
        <#if product_index%4==0>
        <div class="row">
        </#if>
        <li class="col-md-3">
            <a href=/Sell/show?id=${product.id}>
                <div>
                    <img  class="img-responsive"  src=${product.photoAddress} alt=${product.productName}>
                    <h3>${product.productName}</h3>
                    <div>
                        <span>￥</span>
                        <span>${product.price}</span>
                        <span>&&${product_index}</span>
                    </div>
                </div>
            </a>
        </li>
        <#if product_index%4==3 || !product_has_next>
        </div>
        </#if>
    </#list>
    </ul>
</div>