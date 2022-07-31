function formCreateShip() {
  let form = `
  <form>
        <div class="mb-3">
          <label for="inputNameShip" class="form-label">Nave</label>
          <input placeholder="Nombre de la nave" type="text" class="form-control" id="inputNameShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
        <div class="mb-3">
          <label for="inputStartActivityShip" class="form-label">Inicio</label>
          <input type="number" placeholder="2021" class="form-control" id="inputStartActivityShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
        <div class="mb-3">
          <label for="inputEndActivityShip" class="form-label">Finalizó</label>
          <input type="number" placeholder="2022" class="form-control" id="inputEndActivityShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
     
        <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="inputStatusShip">
         <label class="form-check-label" for="defaultCheck1" >Status de la nave</label>
       </div>

        <div class="mb-3">
          <label for="inputCountryShip" class="form-label">País</label>
          <input type="text"  placeholder="Pais" class="form-control" id="inputCountryShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
        <div class="mb-3">
          <label for="inputManufacturerShip" class="form-label">Fabricante</label>
          <input type="text"  placeholder="Fabricante" class="form-control" id="inputManufacturerShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
        <div class="mb-3">
          <label for="inputDescriptionShip" class="form-label">Descripción</label>
          <input type="text" placeholder="Habla sobre la nave" class="form-control" id="inputDescriptionShip" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text"></div>
        <div>
        <hr>

        <button type="submit" class="btn btn-primary" onclick="saveShip()">Crear nave</button>
    </form>`;

  document.getElementById("WhereInsertFormCreateShip").innerHTML = form;
}

function saveShip() {

  let name = document.getElementById("inputNameShip").value;
  let startActivity = document.getElementById("inputStartActivityShip").value;
  let endActivity = document.getElementById("inputEndActivityShip").value;
  let country = document.getElementById("inputCountryShip").value;
  let statusActive = document.getElementById("inputStatusShip").checked;
  let manufacturer = document.getElementById("inputManufacturerShip").value;
  let description = document.getElementById("inputDescriptionShip").value;
  let data = {
    spacecraft: {
      name: name,
      startActivity: startActivity,
      endActivity: endActivity,
      country: country,
      statusActive: statusActive,
      manufacturer: manufacturer,
      description: description,
    },
    keyclient: {
      keyClient: localStorage.getItem("keyClient"),
    },
  };

  fetch("http://localhost:8080/api/spacecraft/ship/save", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-type": "application/json; charset=UTF-8" },
  }).then((data) => {
    console.log(data.status);
    location.reload();
  });

  // alert("SE CREA EL SHIP");
}
