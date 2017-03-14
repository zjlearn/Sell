<#include 'head.ftl'/>

<script type="text/javascript" src="<@spring.url  '/Scripts/sell.js'/>"> </script>

<div class="container">
    <div class="row">
        <h2>内容发布</h2>
    </div>


    <form class=".form-horizontal" role="form" method="post"
          enctype="multipart/form-data"
          action="public/Submit" onsubmit="return true;"
          autocomplete="off">
        <div class="form-group">
            <label for="name" class="col-md-1 control-label">标题</label>
            <div class="col-md-11">
                <input type="text" class="form-control " value="book" name="name" placeholder="请输入商品名称2-80字符">
            </div>
        </div>

        <br></br>

        <div class="form-group">
            <label for="summary" class="col-md-1 control-label">摘要:</label>
            <div class="col-md-11">
                <input type="text" class="form-control" value="this is cs book" name="summary" placeholder="2-140字符">
            </div>
        </div>

        <br></br>

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
            <textarea class="form-control" name="detail" rows="10" placeholder="2-1000个字符"></textarea>
        </div>

        <div class="form-group row">
            <label for="price" class="control-label col-md-1">价格：</label>
            <div class="col-md-11">
                <input type="text" class="form-control" value="1" name="price"/>
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="control-label col-md-1">数量:</label>
            <div class="col-md-11">
                <input type="text" class="form-control" value="1" name="stock"/>
            </div>
        </div>

        <button type="submit" class="btn btn-success">提交</button>
    </form>
</div>

</body>
</html>