//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("dance-form")
const danceContainer = document.getElementById("dance-container")

//Modal Elements
let danceBody = document.getElementById(`dance-body`)
let updateDanceBtn = document.getElementById('update-dance-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/lessons/"

function handleLogout(){
    let c = document.cookie.split(";")
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Tuesday, 6 Oct 2023 00:00:00 GMT"
    }
const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: document.getElementById("dance-input").value
    }
    await addDance(bodyObj);
    document.getElementById("dance-input").value = ''
}

async function addDance(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getDances(userId);
    }
}

async function getDances(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createDanceCards(data))
        .catch(err => console.error(err))
}

async function getDanceById(noteId) {
    await fetch(baseUrl + noteId, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))

}

async function handleDanceEdit(danceId) {
    let bodyObj = {
        id: danceId,
        body: danceBody.value
    }
    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getDances(userId);
}

async function handleDelete(danceId){
    await fetch(baseUrl + danceId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
    return getDances(userId);
}

const createDanceCards = (array) => {
    danceContainer.innerHTML = ''
    array.forEach(obj => {
        let danceCard = document.createElement("div")
        danceCard.classList.add("m-2")
        danceCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                    <p class="card-text">${obj.body}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                        <button onclick="getDanceById(${obj.id})" type="button" class="btn btn-primary" data-bs-toggle="modal data-bs-target="#dance-edit-modal">Edit</button>
                    </div>
                </div>
            </div>
        `
        danceContainer.append(danceCard);
    })
}

const populateModal = (obj) =>{
    danceBody.innerText = ''
    danceBody.innerText = obj.body
    updateDanceBtn.setAttribute('data-dance-id', obj.id)
}

getDances(userId);

submitForm.addEventListener("submit", handleSubmit)

updateDanceBtn.addEventListener("click", (e) => {
    let danceId = e.target.getAttribute('data-dance-id')
    handleDanceEdit(danceId);
})

<a class="btn btn-danger navbar-btn" href="./user.html" onclick="handleLogout">Logout</a>

}