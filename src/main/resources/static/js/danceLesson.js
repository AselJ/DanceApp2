const registerForm = document.getElementById('lesson-form')
const registerLessonName = document.getElementById('lesson-lessonName')
const registerDescription = document.getElementById('lesson-description')

const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/api/v1/danceLessons'
const createLessonCards = (array) => {
        const lessonContainer = document.getElementById('lesson-container')
        lessonContainer.innerHTML = ''
        array.forEach(obj => {

            let lessonCard = document.createElement('div')
            lessonCard.classList.add("m-2")
            lessonCard.innerHTML = `
                <div class="card d-flex" style="width: 200px; height: 150px;">
                    <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                        <h3>${obj.lessonName}</h3>
                        <p class="card-text">${obj.description}</p>
                        <div class="d-flex justify-content-between">
                            <button class="btn btn-dark" onclick="handleDelete(${obj.lessonId})">Delete</button>
                            <button onclick="getLessonById(${obj.lessonId})" type="button" class="btn btn-success" data-bs-toggle="modal data-bs-target="#dance-edit-modal">Edit</button>
                        </div>
                     </div>
                </div>
            `
            lessonContainer.append(lessonCard);
        })
    }
async function getAllDanceLessons() {
    await fetch(`${baseUrl}/all`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createLessonCards(data))
        .catch(err => console.error(err))
}
async function getLessonById(noteId) {
    await fetch(baseUrl + lessonId, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))

}
const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        lessonName: registerLessonName.value,
        description: registerDescription.value
    }

    const response = await fetch(`${baseUrl}/add`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message));
        getAllDanceLessons();

}

//async function handleLessonEdit(lessonId) {
//    let bodyObj = {
//        id: lessonId,
//        body: lessonBody.value
//    }
//    await fetch(baseUrl, /{id}{
//        method: "PUT",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    })
//        .catch(err => console.error(err))
//
//    return getDanceLesson(lessonId);
//}

async function handleDelete(lessonId){
    await fetch(`${baseUrl}/${lessonId}`, {
        method: "DELETE",
        headers: headers
    }).catch(err => console.error(err));
    getAllDanceLessons();
}

registerForm.addEventListener("submit", handleSubmit)


getAllDanceLessons();




