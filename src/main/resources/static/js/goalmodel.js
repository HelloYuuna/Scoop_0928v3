const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const modal1 = document.querySelector('.modal1');
const btnOpenPopup = document.querySelector('.btn-open-popup');
const btnOpenPopup1 = document.querySelector('.btn-open-popup1');

btnOpenPopup.addEventListener('click', () => {
    modal.classList.toggle('show');

    if (modal.classList.contains('show')) {
        body.style.overflow = 'hidden';
    }
});

modal.addEventListener('click', (event) => {
    if (event.target === modal) {
        modal.classList.toggle('show');

        if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
        }
    }
});

// btnOpenPopup1.addEventListener('click', () => {
//     modal.classList.toggle('show');

//     if (modal.classList.contains('show')) {
//         body.style.overflow = 'hidden';
//     }
// });

// modal1.addEventListener('click', (event) => {
//     if (event.target === modal) {
//         modal.classList.toggle('show');

//         if (!modal.classList.contains('show')) {
//             body.style.overflow = 'auto';
//         }
//     }
// });

