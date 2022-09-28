
	      const body = document.querySelector('body');
	      
	      const modal = document.querySelector('.modal');
	      const btnOpenPopup = document.querySelector('.btn-open-popup');
	      
	      const modal1 = document.querySelector('.modal1');
	      const btnOpenPopup1 = document.querySelector('.btn-open-popup1');
	      
	      const modal2 = document.querySelector('.modal2');
	      const btnOpenPopup2 = document.querySelector('.btn-open-popup2');
	
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
	      
	      
	      btnOpenPopup1.addEventListener('click', () => {
	        modal1.classList.toggle('show');
	
	        if (modal1.classList.contains('show')) {
	          body.style.overflow = 'hidden';
	        }
	      });
	
	      modal1.addEventListener('click', (event) => {
	        if (event.target === modal1) {
	          modal1.classList.toggle('show');
	
	          if (!modal1.classList.contains('show')) {
	            body.style.overflow = 'auto';
	          }
	        }
	      });
	      
	      
	      btnOpenPopup2.addEventListener('click', () => {
	        modal2.classList.toggle('show');
	
	        if (modal2.classList.contains('show')) {
	          body.style.overflow = 'hidden';
	        }
	      });
	
	      modal2.addEventListener('click', (event) => {
	        if (event.target === modal2) {
	          modal2.classList.toggle('show');
	
	          if (!modal2.classList.contains('show')) {
	            body.style.overflow = 'auto';
	          }
	        }
	      });
	      
	      // Project Modal
		const modal3 = document.querySelector('.projectmodal');
		const createproject = document.querySelector('.createproject');
		
		createproject.addEventListener('click', () => {
		    modal3.classList.toggle('show');
		
		    if (modal3.classList.contains('show')) {
		        body.style.overflow = 'hidden';
		    }
		});
		
		modal3.addEventListener('click', (event) => {
		    if (event.target === modal3) {
		        modal3.classList.toggle('show');
		
		        if (!modal3.classList.contains('show')) {
		            body.style.overflow = 'auto';
		        }
		    }
		});
