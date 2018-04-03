<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
  <h2>인천공항 안내도</h2>
  <p>원하시는 층의 지도를 클릭해주세요.</p>
</div>

<div class="w3-row-padding">
  <div class="w3-col s3 w3-container">
  <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('B1food');">
    지하 1층 - 음식점, 카페
  </a>
  </div>
  <div class="w3-col s3 w3-container">
  <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('B1bank');">
    지하 1층 - 은행 및 편의시설
  </a>
   <div class="w3-col s3 w3-container">
  <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('1food');">
    1층 음식점, 카페
  </a>
  </div>
  <div class="w3-col s3 w3-container">
    <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('1bank,moblie');">
    1층 - 은행 통신사
    </a>
  </div>
  <div class="w3-col s3 w3-container">
    <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('3bank,moblie');">
    3층 - 은행 통신사
    </a>
  </div>
  <div class="w3-col s3 w3-container">
    <a href="javascript:void(0)" class="w3-hover-opacity" onclick="openImg('3food');">
    3층 - 음식점, 카페
    </a>
  </div>
</div><br>

<div id="B1food" class="picture w3-display-container" style="display:none">
  <img src="images/B1food.png" alt="지하 1층 - 음식점" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent w3-text-white">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-white">지하 1층 - 음식점, 카페</div>
</div>

<div id="B1bank" class="picture w3-display-container" style="display:none">
  <img src="images/B1bank.png" alt="지하 1층 - 음식점" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent w3-text-white">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-black">지하 1층 - 은행 및 편의시설</div>
</div>

<div id="1food" class="picture w3-display-container" style="display:none">
  <img src="images/1food.png" alt="1층 - 음식점" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent w3-text-white">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-black">1층 - 음식점, 카페</div>
</div>

<div id="1bank,moblie" class="picture w3-display-container" style="display:none">
  <img src="images/1bank,moblie.png" alt="Fjords" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent w3-text-white">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-black">1층 - 은행, 통신사</div>
</div>

<div id="3bank,moblie" class="picture w3-display-container" style="display:none">
  <img src="images/3bank,moblie.png" alt="Mountains" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-white">3층 - 은행, 통신사</div>
</div>

<div id="3food" class="picture w3-display-container" style="display:none">
  <img src="images/3food.png" alt="Lights" style="width:100%">
  <span onclick="this.parentElement.style.display='none'" 
  class="w3-display-topright w3-button w3-transparent w3-text-white">&times;</span>
  <div class="w3-display-bottomleft w3-container w3-padding w3-text-white">3층 - 음식점, 카페</div>
</div>

<script>
function openImg(imgName) {
  var i, x;
  x = document.getElementsByClassName("picture");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  document.getElementById(imgName).style.display = "block";
}
</script>

</body>
</html> 