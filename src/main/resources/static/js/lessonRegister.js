const registerForm = document.getElementById('register-form')
const registerUserId = document.getElementById('get-userId')
const registerPassword = document.getElementById('get-lessonId')
const registerPassword = document.getElementById('register-registrationDate')

const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/lessonRegister'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        userId: getUserById.value,
        lessonId: getLessonById.value,
        registrationDate: registerRegistrationDate.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "Post",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if(response.status === 200){
        window.location.replace(responseArr[0])
    }
}
registerForm.addEventListener("submit, handleSubmit")