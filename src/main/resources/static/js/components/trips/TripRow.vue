<template>
	<div>
	<i>({{ trip.id }})</i> {{ trip.itinerary }}
	<span style="position: absolute; right: 0">
		<input type="button" value="Edit" @click="edit" />
		<input type="button" value="X" @click="del" />
	</span>
	</div>
</template>

<script>
export default {
	props: ['trip', 'editTrip', 'deleteTrip', 'trips'],
	methods: {
		edit() {
			this.editTrip(this.trip)
		},
		del() {
			this.deleteTrip(this.trip)
		}
	}
}
</script>

<style scoped>
</style>