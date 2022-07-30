function loadShips() {
  fetch("http://localhost:8080/api/spacecraft/ship/all")
    .then((response) => response.json())
    .then((data) => {
      loadShipsReceived(data);
    });
}

function loadShipsBySearched() {
  let parameter = document.getElementById("inputOfSearch").value;
  fetch(`http://localhost:8080/api/spacecraft/ship/search=${parameter}`)
    .then((response) => response.json())
    .then((data) => {
      loadShipsReceived(data);
    });
}

function loadShipsReceived(data) {
  let isAdminTheClient;
  if (localStorage.getItem("typeClient") == "ADMIN") {
    isAdminTheClient = true;
  } else {
    isAdminTheClient = false;
  }

  let allShips = `
<table class="table">
  <thead>
    <tr>
    <th scope="col">status</th>
    <th scope="col">Nave</th>
    <th scope="col">Inicio</th>
    <th scope="col">Finalizó</th>
    <th scope="col">País</th>
    <th scope="col">Fabricante</th>
    <th scope="col">Descripción</th>
    `;
  if (isAdminTheClient) {
    allShips += `<th scope="col">Edición</th>`;
  }
  allShips += `
    </tr>
  </thead>
  <tbody>
  `;

  data.forEach((ship) => {
    // console.log(ship);
    allShips += ` <tr>`;
    allShips += `<td>${showStatusShip(ship.statusActive)}</td>`;
    allShips += `<td>${ship.name}</td>`;
    allShips += `<td>${ship.startActivity}</td>`;
    allShips += `<td>${ship.endActivity}</td>`;
    allShips += `<td>${ship.country}</td>`;
    allShips += `<td>${ship.manufacturer}</td>`;
    allShips += `<td>${ship.description}</td>`;

    if (isAdminTheClient) {
      allShips += `<td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalEditShip${ship.idShip}">
    Editar
  </button></td>`;
      allShips += `
  <div class="modal fade" id="ModalEditShip${
    ship.idShip
  }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
        Editar la nave ${ship.name}

        <form>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ship</label>
            <input type="email" value="${
              ship.name
            }"  class="form-control" id="inputShip${
        ship.idShip
      }" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Inicio</label>
            <input type="number" value="${
              ship.startActivity
            }"  class="form-control" id="inputStart${
        ship.idShip
      }" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Finalizó</label>
            <input type="number" value="${
              ship.endActivity
            }"  class="form-control" id="inputEnd${
        ship.idShip
      }" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">País</label>
            <input type="text"  value="${
              ship.country
            }" class="form-control" id="inputCountry${
        ship.idShip
      }" aria-describedby="emailHelp">
          </div>
         
          <div class="form-check">
            <input class="form-check-input" type="checkbox" ${ischeckedBox(
              ship.statusActive
            )} value="" id="inputActive${ship.idShip}">
             <label class="form-check-label" for="defaultCheck1" >Status de la nave</label>
           </div>

        
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Fabricante</label>
            <input type="email"  value="${
              ship.manufacturer
            }" class="form-control" id="inputManufacturer${
        ship.idShip
      }" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Descripción</label>
          <input type="email"  value="${
            ship.description
          }" class="form-control" id="inputDescription${
        ship.idShip
      }" aria-describedby="emailHelp">
        </div>
        </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
          <button type="button" class="btn btn-primary" onclick="updateShip(${
            ship.idShip
          })">Guardar cambios</button>
        </div>
      </div>
    </div>
  </div>
  `;
    }
    allShips += `</tr>`;
  });
  allShips += `</tbody></table>`;

  document.getElementById("whereToLoadShips").innerHTML = allShips;
}

function ischeckedBox(statusShip) {
  if (statusShip) {
    return `checked`;
  }
}

function showStatusShip(status) {
  let green = `<button type="" class="btn btn-success"></button>`;
  let red = `<button type="button" class="btn btn-danger"></button>`;
  if (status == true) {
    return green;
  } else {
    return red;
  }
}

function updateShip(id) {
  let name = document.getElementById("inputShip" + id).value;
  let startActivity = document.getElementById("inputStart" + id).value;
  let endActivity = document.getElementById("inputEnd" + id).value;
  let country = document.getElementById("inputCountry" + id).value;
  let statusActive = document.getElementById("inputActive" + id).checked;
  let manufacturer = document.getElementById("inputManufacturer" + id).value;
  let description = document.getElementById("inputDescription" + id).value;

  console.log(document.getElementById("inputActive" + id));

  let data = {
    spacecraft: {
      idShip: id,
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

  fetch(`http://localhost:8080/api/spacecraft/ship/update`, {
    method: "PUT",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  }).then((response) => {
    console.log(response.status);
    location.reload();
  });
}

// <div class="mb-3">
// <label for="exampleInputEmail1" class="form-label">activo?</label>
// <input type="text"  value="${ship.statusActive}" class="form-control" id="inputActive${ship.statusActive}" aria-describedby="emailHelp">
// </div>
