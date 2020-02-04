/**
* Created by PhpStorm.
* User: Sundareswaran
* Date: 29-08-2015
* Time: 23:33
*/
<form action="check.php" method="post" enctype="multipart/form-data">
    <input type="file" name="image" size="50">
    <input type="submit" value="upload">
</form>
<?php
use Eventviva\ImageResize;

if (isset($_FILES['image'])) {
    require 'requireds/ImageResize.php';
    move_uploaded_file($_FILES['image']['tmp_name'], 'image.png');
    $org_info = getimagesize("image.png");
    echo $org_info[3] . '<br><br>';
    $image = new ImageResize('image.png');
    echo "<img src=\"image.png\" alt=\"image\" /><br><br>";
    $image->scale(30);
    $image->save('imageb.png');
}

/*
$org_info = getimagesize("image.png");
echo $org_info[1].' is height<br><br>';
echo $org_info[0].' is width<br><br>';
$rsr_org = imagecreatefrompng("image.png");
$rsr_scl = imagescale($rsr_org, $org_info[0]*0.5, $org_info[1]*0.5,  IMG_BICUBIC_FIXED);
imagepng($rsr_scl, "imagebfb.png");
imagedestroy($rsr_org);
imagedestroy($rsr_scl);
*/
?>
<?php
if (isset($_FILES['image'])) {
    $scl_info = getimagesize("imagebfb.png");
    echo $scl_info[3];
    echo '<img src=\"imageb.png\" alt=\"imagebfb\" /><br><br>';
//unlink('imagebfb.png');
}
?>