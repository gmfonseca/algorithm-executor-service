package br.com.gmfonseca.tcc.application.grpc

import br.com.gmfonseca.tcc.business.service.BubbleSortService
import br.com.gmfonseca.tcc.business.service.GenericAlgorithmService
import br.com.gmfonseca.tcc.business.service.HeapSortService
import br.com.gmfonseca.tcc.business.service.SelectionSortService
import br.com.gmfonseca.tcc.business.service.model.AnComparableObject
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor
import br.com.gmfonseca.tcc.proto.AlgorithmExecutorServiceGrpc.AlgorithmExecutorServiceImplBase
import br.com.gmfonseca.tcc.shared.toAnComparableObjectList
import br.com.gmfonseca.tcc.shared.toAnObjectList
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class AlgorithmExecutorGrpcController : AlgorithmExecutorServiceImplBase() {

    private val bubbleSortService = BubbleSortService()
    private val selectionSortService = SelectionSortService()
    private val heapSortService = HeapSortService()

    override fun executeBubbleSortAlgorithm(request: AlgorithmExecutor.ExecuteSortAlgorithmRequest, responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = when (request.dataCase) {
                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.INTEGERLIST -> {
                    val resultList = bubbleSortService.execute(request.integerList.contentList)
                    val integerList = AlgorithmExecutor.IntegerList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setIntegerList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.FLOATLIST -> {
                    val resultList = bubbleSortService.execute(request.floatList.contentList)
                    val integerList = AlgorithmExecutor.FloatList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setFloatList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.OBJECTLIST -> {
                    val resultList = bubbleSortService.execute(request.objectList.contentList.toAnComparableObjectList())
                    val integerList = AlgorithmExecutor.ObjectList.newBuilder().addAllContent(resultList.toAnObjectList()).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setObjectList(integerList).build()
                }

                else -> throw IllegalArgumentException("Unknown data case")
            }

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    override fun executeSelectionSortAlgorithm(request: AlgorithmExecutor.ExecuteSortAlgorithmRequest, responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = when (request.dataCase) {
                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.INTEGERLIST -> {
                    val resultList = selectionSortService.execute(request.integerList.contentList)
                    val integerList = AlgorithmExecutor.IntegerList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setIntegerList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.FLOATLIST -> {
                    val resultList = selectionSortService.execute(request.floatList.contentList)
                    val integerList = AlgorithmExecutor.FloatList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setFloatList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.OBJECTLIST -> {
                    val resultList = selectionSortService.execute(request.objectList.contentList.toAnComparableObjectList())
                    val integerList = AlgorithmExecutor.ObjectList.newBuilder().addAllContent(resultList.toAnObjectList()).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setObjectList(integerList).build()
                }

                else -> throw IllegalArgumentException("Unknown data case")
            }

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    override fun executeHeapSortAlgorithm(request: AlgorithmExecutor.ExecuteSortAlgorithmRequest, responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = when (request.dataCase) {
                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.INTEGERLIST -> {
                    val resultList = heapSortService.execute(request.integerList.contentList)
                    val integerList = AlgorithmExecutor.IntegerList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setIntegerList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.FLOATLIST -> {
                    val resultList = heapSortService.execute(request.floatList.contentList)
                    val integerList = AlgorithmExecutor.FloatList.newBuilder().addAllContent(resultList).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setFloatList(integerList).build()
                }

                AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.OBJECTLIST -> {
                    val resultList = heapSortService.execute(request.objectList.contentList.toAnComparableObjectList())
                    val integerList = AlgorithmExecutor.ObjectList.newBuilder().addAllContent(resultList.toAnObjectList()).build()
                    AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setObjectList(integerList).build()
                }

                else -> throw IllegalArgumentException("Unknown data case")
            }

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun execute(
            service: GenericAlgorithmService,
            type: AlgorithmExecutor.DataType,
            elements: List<Any>
    ): List<Any> {
        return when (type) {
            AlgorithmExecutor.DataType.FLOAT -> service.execute(elements as List<Float>)
            AlgorithmExecutor.DataType.INTEGER -> service.execute(elements as List<Int>)
            AlgorithmExecutor.DataType.OBJECT -> service.execute(elements as List<AnComparableObject>)
            else -> throw IllegalArgumentException("Invalid parameter type $type")
        }
    }

}
