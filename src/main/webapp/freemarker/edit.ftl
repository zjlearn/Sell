<#include 'head.ftl'/>

<script type="text/javascript" src="<@spring.url  '/Scripts/sell.js'/>"> </script>

<div class="container">
    <div class="row">
        <h2>内容编辑</h2>
    </div>

    <form  class=".form-horizontal" role="form" id="form" method="post"
           enctype="multipart/form-data"
           action="/Sell/product/save" onsubmit="return true;"
           autocomplete="off">
        <input type="text" class="form-control" value=${product.id}   style="" name ="productId">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label" >标题</label>
            <div class="sol-sm-10">
                <input type="text" class="form-control" value=${product.productName}  name ="name">
            </div>
        </div>

        <div class="form-group">
            <label for="summary" class="col-sm-2 control-label">摘要</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value =${product.summary} name="summary" >
            </div>
        </div>

        <div class="form-group">
            <label for="pic" class="col-sm-1 control-label">图片：</label>
            <div class="col-sm-11" id="uploadType">
                <input name="pic" type="radio" value="url" onclick="radioshow()" checked/> 图片地址
                <input name="pic" type="radio" onclick="radioshow()" value="file"/> 本地上传
            </div>
        </div>

        <div class="form-group container">
            <div id="urlUpload">
                <label class="control-label col-md-10"></label>
                <input class="form-control " name="image" placeholder="图片地址"/>
            </div>
            <div class="form-group" id="fileUpload" style="display:none;">
                <label class="sr-only" for="inputfile">文件输入</label>
                <input type="file" class="form-control" id="inputfile" name="productPicture"
                       accept="image/jpeg, image/png,image/gif">
            </div>
        </div>

        <br></br>

        <div class="form-group">
            <label for="name">正文</label>
            <textarea class="form-control"  value=${product.detail} name="detail" rows="10"></textarea>
        </div>

        <div class="form-group">
            <label for="price" class="control-label col-sm-2">价格：</label>
            <div class="col-sm-10">
                <input  type="text" class="form-control"  value =${product.price} name="price"/>元
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="control-label col-sm-2" >库存</label>
            <div class="col-sm-10">
                <input  type="text" class="form-control" value=${product.stock}  name="stock"/>
            </div>
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>

</body>
</html>