/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector(".first").addEventListener("click", function() {
  Swal.fire({
    title: "Are You Sure Save This?",
    showCancelButton: true,
    confirmButtonText: "Confirm",
    confirmButtonColor: "#00ff99",
    cancelButtonColor: "#ff0099"
  });
});


