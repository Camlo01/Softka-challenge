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
    </tr>
  </thead>
  <tbody>
  `;
  data.forEach((ship) => {
    console.log(ship);
    allShips += ` <tr>`;
    allShips += `<td>${showStatusShip(ship.statusActive)}</td>`;
    allShips += `<td>${ship.name}</td>`;
    allShips += `<td>${ship.startActivity}</td>`;
    allShips += `<td>${ship.endActivity}</td>`;
    allShips += `<td>${ship.country}</td>`;
    allShips += `<td>${ship.manufacturer}</td>`;
    allShips += `<td>${ship.description}</td>`;
    allShips += `</tr>`;
  });
  allShips += `</tbody></table>`;
  document.getElementById("whereToLoadShips").innerHTML = allShips;
}

function showStatusShip(status) {
  let green = `<button type="button" class="btn btn-success"></button>`;
  let red = `<button type="button" class="btn btn-danger"></button>`;
  if (status == true) {
    return green;
  } else {
    return red;
  }
}
