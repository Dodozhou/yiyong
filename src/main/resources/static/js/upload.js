/**
 * Created by 15928 on 2017/9/7.
 */
//提示
$(function(){
    $('.tip').css('display','none');
    $('#upbtn>input').click(function(e){
        var $name=$('main>section>form>ul>li:nth-child(2)>input').val();
        var $money1=$('#money1').val();
        var $money2=$('#money2').val();
        var $class=$('#classselect option:selected').val();
        var $detail=$('main>section>form>ul>li:nth-child(5)>input').val();
        if($name==''){
            $('main>section>form>ul>li:nth-child(2)>.tip').css('display','block').html('请输入物品名称');
            e.preventDefault();
        }else{
            $('main>section>form>ul>li:nth-child(2)>.tip').css('display','none');
        }
        if($class=='类别'){
            $('main>section>form>ul>li:nth-child(3)>.tip').css('display','block').html('请选择相关类别');
            e.preventDefault();
        }else{
            $('main>section>form>ul>li:nth-child(3)>.tip').css('display','none');
        }
        if($money1==''||$money2==''||isNaN(Number($money1))==true||isNaN(Number($money2))==true||Number($money1)>=Number($money2)){
            $('main>section>form>ul>li:nth-child(4)>.tip').css('display','block').html('请输入正确的区间范围');
            e.preventDefault();
        }else{
            $('main>section>form>ul>li:nth-child(4)>.tip').css('display','none');
        }
        if($detail==''){
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','block').html('请输入相关描述');
            e.preventDefault();
        }else if($detail.length>30){
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','block').html('输入的描述请少于30字');
            e.preventDefault();
        } else{
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','none');
        }

        if($name!='' && $class!='类别' && $money1!='' && $money2!=''&& $detail!='' && $detail.length<=30){
            e.stopPropagation();
        }
    });

    $('main>section>form>ul>li:nth-child(2)>input').blur(function(){
        var $name=$(this).val();
        if($name==''){
            $('main>section>form>ul>li:nth-child(2)>.tip').css('display','block').html('请输入物品名称');
            e.preventDefault();
        }else{
            $('main>section>form>ul>li:nth-child(2)>.tip').css('display','none');
        }
    });
    $('#classselect').change(function(){
        var $class=$('#classselect option:selected').val();
        if($class=='类别'){
            $('main>section>form>ul>li:nth-child(3)>.tip').css('display','block').html('请选择相关类别');
            e.preventDefault();
        }else{
            $('main>section>form>ul>li:nth-child(3)>.tip').css('display','none');
        }
    });
    $('main>section>form>ul>li:nth-child(5)>input').blur(function(){
        var $detail=$(this).val();
        if($detail==''){
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','block').html('请输入相关描述');
            e.preventDefault();
        }else if($detail.length>30){
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','block').html('输入的描述请少于30字');
        }else{
            $('main>section>form>ul>li:nth-child(5)>.tip').css('display','none');
        }
    })

});

//        图片上传并显示
document.getElementById('file').onchange = function() {
    var imgFile = this.files[0];
    var fr = new FileReader();
    fr.onload = function() {
        document.getElementById('imgdisplay').getElementsByTagName('img')[0].src = fr.result;
    };
    fr.readAsDataURL(imgFile);
};