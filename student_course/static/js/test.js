function myfun() {
  console.log('Success')
  const ps = document.querySelectorAll('p');
  ps.forEach((p, index) => {
    let string = p.innerText;
    string = string.split('')
    p.innerHTML = '';
    string.forEach((value, idx) => {
      console.log(value);
      console.log(idx);
      let span = document.createElement('span');
      span.style.transitionDelay = `${idx * 50}ms`
      p.appendChild(span)
      span.innerHTML = value;
    });
  });
}
export { //很关键
  myfun
}
