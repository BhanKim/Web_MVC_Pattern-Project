const main = document.querySelector("#main");
const qna = document.querySelector("#qna");
const result = document.querySelector("#result");

const endPoint = 3;//3개의 지문에 해당하는 크기지정으로 상태바의 크기지정을 해줌
const select = [0, 0, 0, 0, 0, 0, 0, 0, 0];//사용자가 버튼을 누를 때마다 질문에 대한 값이 저장되어있음 (배열 크기 12)

/*코드의 전체적인 흐름은 main페이지에서 시작하기를 누르면 깜빡거리면서 넘어간 뒤에 사용자가 선택한 문항에 대한 값을 받고 pointArray의 크기만큼 반복하여
pointArray의 name과 target.type[j]이 값으면 해당되는 name의 value값을 1씩 증가한 후 최종적으로 가장 많은 값을 지닌 것을 결과값으로 출력하는 흐름이다.
*/


//가장 많이 선택된 type을 결과화면으로 나오도록 구성함
function calResult(){//결과를 계산할 배열을 만들어 줌
  console.log(select);
  var result = select.indexOf(Math.max(...select));//indexOf는 index값
  return result;//value값이 제일 높은 것이 첫번째 인덱스로 나오게 해줌 값이 같을 경우 제일 처음에 있는 값을 결과값으로 나타냄
}

function setResult(){//결과화면을 띄우기 위한 함수
  let point = calResult();//위에 calResult를 가져와서 결과값을 받아서 결과에 따라서 밑에 값을 넣어줘서 이에 해당되는 이미지를 출력
  const resultName = document.querySelector('.resultname');
  resultName.innerHTML = infoList[point].name;//infoList의 point의 name을 배열로 지정해서 

  var resultImg = document.createElement('img');
  const imgDiv = document.querySelector('#resultImg');//결과 이미지 html에서 가져옴
  var imgURL = 'img/image' + point + '.png';//결과화면의 이미지 불러오는 주소값
  resultImg.src = imgURL;//이미지 주소
  resultImg.alt = point;//공유하기 페이지를 만들기위해 선언함
  resultImg.classList.add('img-fluid');
  imgDiv.appendChild(resultImg);

  const resultDesc = document.querySelector('.resultDesc');
  resultDesc.innerHTML = infoList[point].desc;
}

function goResult(){//화면 깜빡거리면서 나타내는 시간
  qna.style.WebkitAnimation = "fadeOut 1s";
  qna.style.animation = "fadeOut 1s";
  setTimeout(() => {
    result.style.WebkitAnimation = "fadeIn 1s";
    result.style.animation = "fadeIn 1s";
    setTimeout(() => {
      qna.style.display = "none";
      result.style.display = "block"
    }, 450)})
    setResult();
}

function ImageFadeOut(qIdx, idx){
  var left = document.querySelector('.leftImage');
  var middle = document.querySelector('.middleImage');
  var right = document.querySelector('.rightImage');
  left.disabled = true;
  left.classList.remove("fadeIn");
  left.classList.add("fadeOut");
  
  middle.disabled = true;
  middle.classList.remove("fadeIn");
  middle.classList.add("fadeOut");
  
  right.disabled = true;
  right.classList.remove("fadeIn");
  right.classList.add("fadeOut");

  setTimeout(() =>{
    if(qIdx+1 === endPoint){
      goResult();
      return;
    } else{
      setTimeout(() => {
        var target = qnaList[qIdx].a[idx].type;
        for(let i = 0; i < target.length; i++){
          select[target[i]] += 1;
        }
        goNext(++qIdx);
      },450);
    }
  },450)

}

function goNext(qIdx){//image적용시키기 위한 함수
  var q = document.querySelector('.qBox');
  q.innerHTML = qnaList[qIdx].q;

  var left = document.querySelector('.leftImage');
  var middle = document.querySelector('.middleImage');
  var right = document.querySelector('.rightImage');
  
  var qnaURL = './img/question/';
  left.src = qnaURL + qIdx + '-A.png';
  middle.src = qnaURL + qIdx + '-B.png';
  right.src = qnaURL + qIdx + '-C.png';

  try {
    left.classList.remove("fadeOut");
    middle.classList.remove("fadeOut");
    right.classList.remove("fadeOut");
  } catch (e) {
    console.log(e);
  }
  
  left.classList.add("fadeIn");
  middle.classList.add("fadeIn");
  right.classList.add("fadeIn");

  left.addEventListener("click", function(){
    var target = qnaList[qIdx].a[0].type;
    ImageFadeOut(qIdx ,0);
  }, false);

  middle.addEventListener("click", function(){
    var target = qnaList[qIdx].a[1].type;
    ImageFadeOut(qIdx, 1);
  }, false);
  
  right.addEventListener("click", function(){
    var target = qnaList[qIdx].a[2].type;
    ImageFadeOut(qIdx, 2);
  }, false);

  var status = document.querySelector('.statusBar');//상태바를 불러줌
  status.style.width = (100/endPoint) * (qIdx+1) + '%';//style 상태바가 어느정도 채워질 것인지 나타냄
}

function begin(){//화면 깜빡이며 넘어가는 역할을 함
  main.style.WebkitAnimation = "fadeOut 1s";//버튼 눌렀을 때에 사라졌다가 다시 나오는 시간
  main.style.animation = "fadeOut 1s";//버튼 눌렀을 때에 사라졌다가 다시 나오는 시간
  setTimeout(() => {
    qna.style.WebkitAnimation = "fadeIn 1s";//버튼 눌렀을 때에 사라졌다가 다시 나오는 시간
    qna.style.animation = "fadeIn 1s";//버튼 눌렀을 때에 사라졌다가 다시 나오는 시간
    setTimeout(() => {
      main.style.display = "none";
      qna.style.display = "block"
    }, 450)
    let qIdx = 0;
    goNext(qIdx);
  }, 450);
}
