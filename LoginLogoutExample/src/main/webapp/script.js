
const menuToggle = document.getElementById("menuToggle");
const navLinks = document.getElementById("navLinks");

// Mobile navigation
menuToggle.addEventListener("click", function () {
    navLinks.classList.toggle("active");
});

// Close menu after clicking a navigation link
document.querySelectorAll(".nav-links a").forEach(function (link) {
    link.addEventListener("click", function () {
        navLinks.classList.remove("active");
    });
});

// Automatically update copyright year
document.getElementById("year").textContent =
    new Date().getFullYear();

	const loginForm = document.getElementById("loginForm");

	if (loginForm) {
	    loginForm.addEventListener("submit", function(event) {
	        event.preventDefault();

	        let email = document.getElementById("email").value;
	        let password = document.getElementById("password").value;

	        if (email === "" || password === "") {
	            alert("Please enter email and password");
	            return;
	        }

	        alert("Login form submitted successfully!");

	        // Backend authentication will be added here.
	    });
	}
	
	

	const registerForm = document.getElementById("registerForm");

	if (registerForm) {

	    registerForm.addEventListener("submit", function(event) {

	        event.preventDefault();

	        let name = document.getElementById("fullname").value;
	        let email = document.getElementById("email").value;
	        let mobile = document.getElementById("mobile").value;
	        let gender = document.getElementById("gender").value;

	        let password = document.getElementById("password").value;
	        let confirmPassword = document.getElementById("confirmPassword").value;

	        let terms = document.getElementById("terms").checked;

	        if (password !== confirmPassword) {
	            alert("Password and Confirm Password do not match!");
	            return;
	        }

	        if (password.length < 8) {
	            alert("Password must contain at least 8 characters!");
	            return;
	        }

	        if (!terms) {
	            alert("Please accept Terms & Conditions!");
	            return;
	        }

	        let user = {
	            name: name,
	            email: email,
	            mobile: mobile,
	            gender: gender
	        };

	        console.log("Registration Data:", user);

	        alert("Registration form submitted successfully!");

	        // Backend and database integration will be added later.

	    });

	}

