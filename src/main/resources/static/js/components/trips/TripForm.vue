<template>
	<div>
		<input type="text" placeholder="Write something" v-model="text" />
		<input type="button" value="Save" @click="save" />
	</div>
</template>

<script>
function getIndex(list, id) {
	for (let i = 0; i < list.length; i++) {
		if (list[i].id === id) {
			return i
		}
	}
	return -1
}
export default {
	props: ['trips', 'tripAttr'],
	data() {
		return {
			text: '',
			id: ''
		}
	},
	watch: {
		tripAttr(newVal, oldVal) {
			this.text = newVal.itinerary
			this.id = newVal.id
		}
	},
	methods: {
		save() {
			if (this.id) {
				axios.put('/trip/' + this.id, {
					id: this.id,
					itinerary: this.text
				}).then(response => {
					const index = getIndex(this.trips, response.data.id)
					this.trips.splice(index, 1, response.data)
					this.text = ''
					this.id = ''
				})
			} else {
				axios.post('/trip', {
					itinerary: this.text
				}).then(response => {
					this.trips.push(response.data)
					this.text = ''
				})
			}
		}
	}
}
</script>

<style scoped>
</style> 